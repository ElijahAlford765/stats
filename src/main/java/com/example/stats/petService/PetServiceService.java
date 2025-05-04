package com.example.stats.petService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PetServiceService {
    @Autowired
    private PetServiceRepository petServiceRepository;

    public PetService addService(PetService petService) {
        return petServiceRepository.save(petService);
    }

    public List<PetService> getAllServices() {
        return petServiceRepository.findAll();
    }

    public Optional<PetService> getServiceById(int id) {
        return petServiceRepository.findById(id);
    }

    public Optional<PetService> updateService(int id, PetService updatedService) {
        return petServiceRepository.findById(id).map(existingService -> {
            existingService.setDescription(updatedService.getDescription());
            existingService.setPrice(updatedService.getPrice());
            existingService.setAvailability(updatedService.getAvailability());
            return petServiceRepository.save(existingService);
        });
    }

    public boolean deleteService(int id) {
        if (petServiceRepository.existsById(id)) {
            petServiceRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public long countByStatus(String status) {
        return petServiceRepository.countByStatus(status);
    }

    public String getMostPopularServiceName() {
        // Example placeholder logic, update according to your schema
        return petServiceRepository.findTopByOrderByPopularityDesc()
                .map(PetService::getDescription)
                .orElse("N/A");
    }
}
