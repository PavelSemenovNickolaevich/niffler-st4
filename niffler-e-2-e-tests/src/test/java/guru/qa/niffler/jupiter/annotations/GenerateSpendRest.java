package guru.qa.niffler.jupiter.annotations;

import guru.qa.niffler.db.model.CurrencyValues;
import guru.qa.niffler.jupiter.extension.RestSpendExtension;
import guru.qa.niffler.jupiter.extension.SpendResolverExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith({RestSpendExtension.class, SpendResolverExtension.class})
public @interface GenerateSpendRest {
    String username();

    String description();

    String category();

    double amount();

    CurrencyValues currency();
}