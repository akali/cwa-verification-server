package app.coronawarn.verification.controller;

import app.coronawarn.verification.model.RegistrationToken;
import app.coronawarn.verification.model.RegistrationTokenKeyType;
import app.coronawarn.verification.model.RegistrationTokenRequest;
import app.coronawarn.verification.service.AppSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Order(100)
public class TanStubber implements ApplicationRunner {
  public static final RegistrationTokenRequest registrationTokenRequest =
    new RegistrationTokenRequest("7777777777", RegistrationTokenKeyType.TELETAN);

  private final AppSessionService appSessionService;

  public TanStubber(AppSessionService appSessionService) {
    this.appSessionService = appSessionService;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    RegistrationToken registrationToken =
      appSessionService.generateRegistrationTokenByTeleTan(registrationTokenRequest.getKey()).getBody();
  }
}
