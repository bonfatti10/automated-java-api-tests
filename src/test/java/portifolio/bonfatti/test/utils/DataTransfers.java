package portifolio.bonfatti.test.utils;

import net.datafaker.Faker;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class DataTransfers {
    Faker faker = new Faker(new Locale("pt-BR"));

    public Map transfer() {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("amount", "1");
        params.put("Descripition", faker.name().fullName());
        params.put("date", "20201002150000");
        params.put("beneficiary_name", faker.name().fullName());
        Map<String, Object> fromAccount = new LinkedHashMap<>();
        params.put("from_account", fromAccount);
        fromAccount.put("id", System.getProperty("id"));
        fromAccount.put("account_number", System.getProperty("account_number"));
        fromAccount.put("agency_account", System.getProperty("agency_account"));
        fromAccount.put("cpf_number", System.getProperty("cpf_number"));

        return params;
    }

}

