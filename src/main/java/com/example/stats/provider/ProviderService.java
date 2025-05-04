package com.example.stats.provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Optional<Provider> updateProvider(int id, Provider providerDetails) {
        return providerRepository.findById(id).map(existingProvider -> {
            existingProvider.setAbout(providerDetails.getAbout());
            existingProvider.setExperience(providerDetails.getExperience());
            existingProvider.setApprovalStatus(providerDetails.getApprovalStatus());
            return providerRepository.save(existingProvider);
        });
    }

    public Optional<Provider> getProviderById(int id) {
        return providerRepository.findById(id);
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public boolean deleteProvider(int id) {
        if (providerRepository.existsById(id)) {
            providerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
