package org.example.news_aggregator.service.impl;

import com.cloudinary.Cloudinary;
import org.example.news_aggregator.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    Map.of(
                            "folder", "products",
                            "resource_type", "image"
                    )
            );
            return uploadResult.get("secure_url").toString();
        } catch (Exception e) {
            throw new RuntimeException("Cloudinary image upload failed", e);
        }
    }

    @Override
    public void deleteImage(String imageUrl) {
        try {
            String publicId = imageUrl
                    .substring(imageUrl.indexOf("products"))
                    .replaceAll("\\.[a-zA-Z]+$", "");

            cloudinary.uploader().destroy(publicId, Map.of());
        } catch (Exception e) {
            throw new RuntimeException("Cloudinary delete failed", e);
        }
    }
}
