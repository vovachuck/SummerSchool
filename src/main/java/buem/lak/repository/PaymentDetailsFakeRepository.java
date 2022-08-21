package buem.lak.repository;

import buem.lak.model.Client;
import buem.lak.model.PaymentDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PaymentDetailsFakeRepository {
    private LocalDateTime now = LocalDateTime.now();

//    private List<PaymentDetails> paymentDetailsList = new ArrayList<>(
//            Arrays.asList(
//                    new PaymentDetails(UUID.randomUUID().toString(), "Volodymyr Lakusta", "Student", now, now, "Hlinichka 1", "+38099023452", "Mykyta Plotnikov"),
//                    new PaymentDetails(UUID.randomUUID().toString(), "Mykyta Plotnikov", "Tiktoker", now, now, "Hlinichka 1", "+38099056723", "Yevhen Darovykh"),
//                    new PaymentDetails(UUID.randomUUID().toString(), "Yevhen Darovykh", "Quiet person", now, now, "Hlinichka 1", "+38099456734", "Volodymyr Lakusta")
//            ));
}
