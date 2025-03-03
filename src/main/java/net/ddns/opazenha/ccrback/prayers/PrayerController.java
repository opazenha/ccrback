package net.ddns.opazenha.ccrback.prayers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ddns.opazenha.ccrback.users.User;
import net.ddns.opazenha.ccrback.users.UserService;

@RestController
@RequestMapping("/api/v1/prayers")
public class PrayerController {
    private final PrayerService prayerService;
    private final UserService userService;

    public PrayerController(PrayerService prayerService, UserService userService) {
        this.prayerService = prayerService;
        this.userService = userService;
    }
    
    @PostMapping("/")
    public ResponseEntity<Object> savePrayer(@RequestBody PrayerCreationDTO request) {
        System.out.println("Received prayer request: " + request);
        System.out.println("userId: " + request.getUserId());
        System.out.println("userName: " + request.getUserName());
        System.out.println("userEmail: " + request.getUserEmail());
        System.out.println("prayerRequest: " + request.getPrayerRequest());
        
        User user = null;
        
        if (request.getUserId() != null) {
            System.out.println("Looking up user by ID: " + request.getUserId());
            user = userService.getUserById(request.getUserId());
        } else if (request.getUserName() != null) {
            System.out.println("Looking up user by name: " + request.getUserName());
            user = userService.getUserByName(request.getUserName());
        } else if (request.getUserEmail() != null) {
            System.out.println("Looking up user by email: " + request.getUserEmail());
            user = userService.getUserByEmail(request.getUserEmail());
        }
        
        if (user == null) {
            System.out.println("User not found!");
            return ResponseEntity.badRequest().body("User not found");
        }
        
        System.out.println("Found user: " + user.getName() + " (ID: " + user.getId() + ")");
        
        Prayer prayer = new Prayer();
        prayer.setRequesterId(user.getId());
        prayer.setPrayerRequest(request.getPrayerRequest());
        prayer.setStatus(PrayerStatus.PENDING);
        
        System.out.println("Saving prayer: " + prayer);
        ResponseEntity<Object> response = prayerService.savePrayer(prayer);
        System.out.println("Prayer saved: " + response);
        return response;
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Prayer>> getPrayers() {
        System.out.println("Getting all prayers");
        ResponseEntity<List<Prayer>> response = ResponseEntity.ok(prayerService.getPrayers());
        System.out.println("Got all prayers: " + response);
        return response;
    }

    @GetMapping("/requester/{requesterId}")
    public ResponseEntity<List<Prayer>> getPrayersByRequesterId(@PathVariable Long requesterId) {
        System.out.println("Getting prayers by requester ID: " + requesterId);
        ResponseEntity<List<Prayer>> response = ResponseEntity.ok(prayerService.getPrayersByRequesterId(requesterId));
        System.out.println("Got prayers by requester ID: " + response);
        return response;
    }

    @GetMapping("/id/{prayerId}")
    public ResponseEntity<Object> getPrayerById(@PathVariable Long prayerId) {
        System.out.println("Getting prayer by ID: " + prayerId);
        ResponseEntity<Object> response = this.prayerService.getPrayerById(prayerId);
        System.out.println("Got prayer by ID: " + response);
        return response;
    }

    @PutMapping("/status/{prayerId}")
    public ResponseEntity<Object> updatePrayerStatus(@PathVariable Long prayerId, @RequestBody PrayerStatus status) {
        System.out.println("Updating prayer status: " + prayerId + " to " + status);
        ResponseEntity<Object> response = this.prayerService.updatePrayerStatus(prayerId, status);
        System.out.println("Updated prayer status: " + response);
        return response;
    }

    @PutMapping("/request/{prayerId}")
    public ResponseEntity<Object> updatePrayerRequest(@PathVariable Long prayerId, @RequestBody String prayerRequest) {
        System.out.println("Updating prayer request: " + prayerId + " to " + prayerRequest);
        ResponseEntity<Object> response = this.prayerService.updatePrayerRequest(prayerId, prayerRequest);
        System.out.println("Updated prayer request: " + response);
        return response;
    }

    @DeleteMapping("/delete/{prayerId}")
    public ResponseEntity<Object> deletePrayer(@PathVariable Long prayerId) {
        System.out.println("Deleting prayer: " + prayerId);
        ResponseEntity<Object> response = this.prayerService.deletePrayer(prayerId);
        System.out.println("Deleted prayer: " + response);
        return response;
    }
}
