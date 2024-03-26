package school.hei.soratra.mail;

import jakarta.mail.internet.InternetAddress;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.soratra.PojaGenerated;
import software.amazon.awssdk.services.ses.model.VerifyEmailIdentityRequest;

@Component
@AllArgsConstructor
@PojaGenerated
public class EmailAddressVerifier implements Consumer<InternetAddress> {

  private final EmailConf emailConf;

  @Override
  public void accept(InternetAddress emailAddress) {
    emailConf
        .getSesClient()
        .verifyEmailIdentity(
            VerifyEmailIdentityRequest.builder().emailAddress(emailAddress.getAddress()).build());
  }
}
