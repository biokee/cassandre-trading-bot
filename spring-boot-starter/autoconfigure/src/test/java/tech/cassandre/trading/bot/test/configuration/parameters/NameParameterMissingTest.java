package tech.cassandre.trading.bot.test.configuration.parameters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import tech.cassandre.trading.bot.CassandreTradingBot;
import tech.cassandre.trading.bot.test.util.junit.BaseTest;
import tech.cassandre.trading.bot.test.util.junit.configuration.Configuration;
import tech.cassandre.trading.bot.test.util.junit.configuration.Property;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static tech.cassandre.trading.bot.util.parameters.ExchangeParameters.PARAMETER_NAME;

@DisplayName("Configuration parameters - Name parameter is missing")
@Configuration({
        @Property(key = PARAMETER_NAME)
})
public class NameParameterMissingTest extends BaseTest {

    @Test
    @DisplayName("Check error messages")
    public void checkErrorMessages() {
        try {
            SpringApplication application = new SpringApplication(CassandreTradingBot.class);
            application.run();
            fail("Exception not raised");
        } catch (Exception e) {
            final String message = getParametersExceptionMessage(e);
            assertTrue(message.contains("'name'"));
            assertFalse(message.contains("'sandbox'"));
            assertFalse(message.contains("'sandbox'"));
            assertFalse(message.contains("'username'"));
            assertFalse(message.contains("'passphrase'"));
            assertFalse(message.contains("'key'"));
            assertFalse(message.contains("'secret'"));
            assertFalse(message.contains("'rates.account'"));
            assertFalse(message.contains("'rates.ticker'"));
            assertFalse(message.contains("'rates.trade'"));
        }
    }

}
