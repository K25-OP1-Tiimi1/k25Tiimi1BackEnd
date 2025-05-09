package k25tiimi1backend.k25tiimi1backend.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import k25tiimi1backend.k25tiimi1backend.domain.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class ReservationRestController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/reservation")

    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest request) {
        User user = userRepository.findByEmail(request.email);

        if (!user.getPassword().equals(request.password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        Product product = productRepository.findById(request.item.getId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Reservation reservation = new Reservation();
        reservation.setUser(user); 
        reservation.setProduct(product);
        reservation.setQuantity(request.count);

        reservationRepository.save(reservation);

        return ResponseEntity.ok(reservation);
    }

}
