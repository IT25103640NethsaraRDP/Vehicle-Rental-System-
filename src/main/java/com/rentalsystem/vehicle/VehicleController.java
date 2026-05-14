package com.rentalsystem.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/add")
    public String showAddForm() {
        return "vehicle/add-vehicle";
    }

    @PostMapping("/add")
    public String addVehicle(
            @RequestParam String type, @RequestParam String brand, @RequestParam String modelName, 
            @RequestParam String regNumber, @RequestParam double dailyRate,
            @RequestParam(required = false) Integer seatingCapacity,
            @RequestParam(required = false) Boolean hasGear,
            @RequestParam(required = false) Double loadCapacity,
            @RequestParam(required = false, value = "image") org.springframework.web.multipart.MultipartFile image) {
        
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            try {
                String imgName = java.util.UUID.randomUUID().toString() + "_" + image.getOriginalFilename();

                // Save to src (persists across rebuilds)
                java.nio.file.Path srcPath = java.nio.file.Paths.get("src/main/resources/static/img/" + imgName);
                java.nio.file.Files.createDirectories(srcPath.getParent());
                java.nio.file.Files.copy(image.getInputStream(), srcPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

                // Also save to the running target directory so it's served immediately without a rebuild
                java.nio.file.Path targetPath = java.nio.file.Paths.get("target/classes/static/img/" + imgName);
                java.nio.file.Files.createDirectories(targetPath.getParent());
                java.nio.file.Files.copy(srcPath, targetPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

                imageUrl = "/img/" + imgName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        vehicleService.addVehicle(type, brand, modelName, regNumber, dailyRate, seatingCapacity, hasGear, loadCapacity, imageUrl);
        return "redirect:/vehicles/list";
    }

    @GetMapping("/list")
    public String listVehicles(Model model) {
        java.util.List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        java.util.List<Vehicle> activeVehicles = allVehicles.stream().filter(Vehicle::isActive).toList();
        java.util.List<Vehicle> inactiveVehicles = allVehicles.stream().filter(v -> !v.isActive()).toList();
        
        model.addAttribute("activeVehicles", activeVehicles);
        model.addAttribute("inactiveVehicles", inactiveVehicles);
        return "vehicle/list-vehicles";
    }

    @GetMapping("/search")
    public String searchVehicles(@RequestParam(required = false) String keyword, Model model) {
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("vehicles", vehicleService.searchVehicles(keyword));
        }
        return "vehicle/search-vehicle";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Vehicle v = vehicleService.getVehicleById(id);
        if (v == null) return "redirect:/vehicles/list";
        model.addAttribute("vehicle", v);
        return "vehicle/edit-vehicle";
    }

    @PostMapping("/update")
    public String updateVehicle(
            @RequestParam Long id,
            @RequestParam String brand,
            @RequestParam String modelName,
            @RequestParam String regNumber,
            @RequestParam double dailyRate,
            @RequestParam(defaultValue = "false") boolean available,
            @RequestParam(required = false, value = "image") org.springframework.web.multipart.MultipartFile image) {

        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            try {
                String imgName = java.util.UUID.randomUUID().toString() + "_" + image.getOriginalFilename();

                java.nio.file.Path srcPath = java.nio.file.Paths.get("src/main/resources/static/img/" + imgName);
                java.nio.file.Files.createDirectories(srcPath.getParent());
                java.nio.file.Files.copy(image.getInputStream(), srcPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

                java.nio.file.Path targetPath = java.nio.file.Paths.get("target/classes/static/img/" + imgName);
                java.nio.file.Files.createDirectories(targetPath.getParent());
                java.nio.file.Files.copy(srcPath, targetPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

                imageUrl = "/img/" + imgName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        vehicleService.updateVehicle(id, brand, modelName, regNumber, dailyRate, available, imageUrl);
        return "redirect:/vehicles/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles/list";
    }

    @GetMapping("/restore/{id}")
    public String restoreVehicle(@PathVariable Long id) {
        vehicleService.restoreVehicle(id);
        return "redirect:/vehicles/list";
    }
}
