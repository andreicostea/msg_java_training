package msg.user.control.computation;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class ComputationService {

    @Inject
    private ComputationProcessor mProcessor;

    public void sendMail(final String emailAdrres,final String firstName, final String userName, final String password) {
        mProcessor.sendEmail(emailAdrres,firstName,userName,password);
    }
}