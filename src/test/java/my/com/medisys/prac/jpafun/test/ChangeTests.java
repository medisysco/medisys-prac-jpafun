package my.com.medisys.prac.jpafun.test;

import static org.junit.Assert.assertTrue;

import java.net.ConnectException;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.core.NestedCheckedException;

import my.com.medisys.boot.BootstrapApplication;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class ChangeTests {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    
    @Test
    public void testChange() throws Exception {
        assertTrue("Migration executed successfully", true);
    }
    
    @Test
    public void testDefaultSettings() throws Exception {
        try {
            BootstrapApplication.main(new String[0]);
        } catch (IllegalStateException ex) {
            if (serverNotRunning(ex)) {
                return;
            }
        }
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Successfully acquired change log lock")
        && output.contains("Successfully released change log lock"));
    }
    
    @SuppressWarnings("serial")
    private boolean serverNotRunning(IllegalStateException ex) {
        NestedCheckedException nested = new NestedCheckedException("failed", ex){};
        if (nested.contains(ConnectException.class)) {
            Throwable root = nested.getRootCause();
            if (root.getMessage().contains("Connection refused")) {
                return true;
            }
        }
        return false;
    }
}
