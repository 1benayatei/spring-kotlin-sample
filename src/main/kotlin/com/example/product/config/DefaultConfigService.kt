package com.example.product.config

import com.example.product.config.exception.ConfigExistsException
import com.example.product.config.exception.ConfigNotFoundException
import com.example.product.product.ProductService
import org.springframework.stereotype.Service

@Service
class DefaultConfigService(val configRepository: ConfigRepository, val productService: ProductService) : ConfigService {
    override fun create(config: Config): Config {
        productService.findById(config.productId) // Find product by id for check is exists.
        configRepository.existsByProductId(config.productId).compareTo(true).let {
            if (it == 0) throw ConfigExistsException();
        }
        return configRepository.save(config);
    }

    override fun update(id: Long, data: Config): Config {
        val config = findById(id);

        if (data.visible != null) config.visible = data.visible;
        if (data.commentable != null) config.commentable = data.commentable;
        if (data.votable != null) config.votable = data.votable;

        return configRepository.save(config);
    }

    override fun findById(id: Long): Config {
        return configRepository.findById(id).orElseThrow {
            throw ConfigNotFoundException()
        };
    }

    override fun findByProductId(productId: Long): Config {
        return configRepository.findByProductId(productId).orElseThrow {
            throw ConfigNotFoundException()
        };
    }
}