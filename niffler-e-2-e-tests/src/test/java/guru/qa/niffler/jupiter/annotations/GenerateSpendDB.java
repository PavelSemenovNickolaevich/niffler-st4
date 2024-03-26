package guru.qa.niffler.jupiter.annotations;

import guru.qa.niffler.db.model.CurrencyValues;
import guru.qa.niffler.jupiter.extension.DatabaseSpendExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith({DatabaseSpendExtension.class})
public @interface GenerateSpendDB {
    String username();

    String description();

    String category();

    double amount();

    CurrencyValues currency();
}
