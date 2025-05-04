package com.example.stats.Stats;

import com.example.stats.petService.PetService;
import com.example.stats.petService.PetServiceRepository;
import com.example.stats.provider.Provider;
import com.example.stats.provider.ProviderRepository;
import com.example.stats.review.Review;
import com.example.stats.review.ReviewRepository;
import com.example.stats.user.User;
import com.example.stats.user.UserRepository;
import com.example.stats.review.ReviewService;
import com.example.stats.petService.PetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stats")
public class statsController {

    private final UserRepository userRepository;
    private final PetServiceRepository petServiceRepository;
    private final statsRepository statsRepository;
    private final statsService statsService;
    private final ReviewService reviewService;
    private final PetServiceService petServiceService;
    private final ProviderRepository providerRepository;

    @Autowired
    public statsController(UserRepository userRepository,
                           PetServiceRepository petServiceRepository,
                           statsRepository statsRepository,
                           statsService statsService,
                           ReviewService reviewService,
                           PetServiceService petServiceService, ProviderRepository providerRepository) {
        this.userRepository = userRepository;
        this.petServiceRepository = petServiceRepository;
        this.statsRepository = statsRepository;
        this.statsService = statsService;
        this.reviewService = reviewService;
        this.petServiceService = petServiceService;
        this.providerRepository = providerRepository;
    }

    // ====== Admin Dashboard Views ======

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/admin-moderation")
    public String moderateServices(Model model) {
        model.addAttribute("services", petServiceRepository.findAll());
        model.addAttribute("pendingServices", petServiceRepository.findByStatus("PENDING"));
        model.addAttribute("flaggedServices", petServiceRepository.findByFlaggedTrue());
        return "admin-moderation";
    }

    @GetMapping("/users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "manage-users";
    }

    @GetMapping("/view")
    public String viewStats(Model model) {
        model.addAttribute("activeUsersJan", userRepository.countByActiveAndMonth(1));
        model.addAttribute("activeUsersFeb", userRepository.countByActiveAndMonth(2));
        model.addAttribute("activeUsersMar", userRepository.countByActiveAndMonth(3));
        model.addAttribute("activeUsersApr", userRepository.countByActiveAndMonth(4));
        model.addAttribute("overallAvg", reviewService.getAverageRating());
        model.addAttribute("statsList", statsService.getAllStatistics());
        model.addAttribute("title", "Usage Statistics");
        return "admin-stats";
    }





    @PostMapping("/services/approve/{id}")
    public String approveService(@PathVariable int id) {
        petServiceRepository.findById(id).ifPresent(service -> {
            service.setApproved(true);
            service.setStatus("APPROVED");
            petServiceRepository.save(service);
        });
        return "redirect:/stats/admin-moderation";
    }

    @PostMapping("/services/delete/{id}")
    public String deleteService(@PathVariable int id) {
        petServiceRepository.deleteById(id);
        return "redirect:/stats/admin-moderation";
    }

    // ====== Statistics Views ======

    @GetMapping
    public List<stats> getAllStatistics(Model model) {
        return statsService.getAllStatistics();
    }

    @GetMapping("/live")
    public stats getLiveStats(Model model) {
        return statsService.generateLiveStats();
    }

    @PostMapping("/snapshot")
    public void saveStatsSnapshot(Model model) {
        statsService.saveCurrentStatsSnapshot();

    }

    @DeleteMapping("/{id}")
    public void deleteStatisticsById(@PathVariable int id) {
        statsService.deleteStatisticsById(id);
    }


    @GetMapping("/applist")
    public String appList(Model model) {
        // Retrieve all applications
        List<Provider> providers = providerRepository.findAll(); // Ensure providerRepository is injected

        // Add providers and related user information to the model
        model.addAttribute("applications", providers);

        // Retrieve applications with different statuses (approved, denied, pending)
        model.addAttribute("pendingApplications", petServiceRepository.findByStatus("PENDING"));
        model.addAttribute("approvedApplications", petServiceRepository.findByStatus("APPROVED"));
        model.addAttribute("deniedApplications", petServiceRepository.findByStatus("DENIED"));

        // Retrieve all users to associate applications with users (if needed)
        model.addAttribute("users", userRepository.findAll());

        // Return the view for the app-list page
        return "app-list";

    }


    @GetMapping("/reviews")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews(); // use service for abstraction
        model.addAttribute("reviews", reviews);


        return "admin-reviews"; // Ensure this matches your Freemarker template file name
    }
}
