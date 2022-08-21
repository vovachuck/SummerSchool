package buem.lak.repository;

import buem.lak.model.Client;
import buem.lak.model.PaymentDetails;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

@Repository
public class PaymentDetailsFakeRepository {
    private LocalDateTime now = LocalDateTime.now();

    private List<PaymentDetails> paymentDetailsList = new ArrayList<>(
            Arrays.asList(
                    new PaymentDetails(UUID.randomUUID().toString(), "name1", "description1", now, now, "SK6807200002891987426353", "1234123412341234", "232", LocalDate.of(2023, 7, 1).atStartOfDay()),
                    new PaymentDetails(UUID.randomUUID().toString(), "name2", "description2", now, now, "SK6807200002891987426453", "2345234523452345", "111", LocalDate.of(2025, 2, 1).atStartOfDay()),
                    new PaymentDetails(UUID.randomUUID().toString(), "name3", "description3", now, now, "SK6807200002891987426666", "5678567856785678", "333", LocalDate.of(2027, 11, 1).atStartOfDay())
            ));

    public List<PaymentDetails> findAll() {
        return this.paymentDetailsList;
    }

    public PaymentDetails save(PaymentDetails paymentDetails) {
        paymentDetails.setId(UUID.randomUUID().toString());
        paymentDetails.setCreateAt(now);
        paymentDetails.setUpdateAt(now);
        this.paymentDetailsList.add(paymentDetails);
        return paymentDetails;
    }

    public PaymentDetails findById(String id) {
        return this.paymentDetailsList.stream().filter(paymentDetails -> paymentDetails.getId().equals(id))
                .findFirst().orElse(null);
    }

    public PaymentDetails update(PaymentDetails paymentDetails) {
        this.deleteById(paymentDetails.getId());
        paymentDetails.setUpdateAt(LocalDateTime.now());
        this.paymentDetailsList.add(paymentDetails);
        return paymentDetails;
    }

    public void deleteById(String id) {
        PaymentDetails paymentDetails = this.findById(id);
        int index = paymentDetailsList.indexOf(paymentDetails);
        this.paymentDetailsList.remove(index);
    }
}
