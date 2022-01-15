package com.example.product.config

import com.example.product.common.API_CONFIG_CREATE
import com.example.product.common.API_CONFIG_GET
import com.example.product.common.API_CONFIG_UPDATE
import com.example.product.config.dto.ConfigCreationDto
import com.example.product.config.dto.ConfigDto
import com.example.product.config.dto.ConfigUpdateDto
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class ConfigController(var configService: ConfigService) {

    @GetMapping(API_CONFIG_GET)
    @ResponseStatus(OK)
    fun get(@PathVariable id: Long) = ConfigDto().of(configService.findById(id));

    @PostMapping(API_CONFIG_CREATE)
    @ResponseStatus(CREATED)
    fun create(@Valid @RequestBody data: ConfigCreationDto) = ConfigDto().of(configService.create(data.toConfig()));

    @PatchMapping(API_CONFIG_UPDATE)
    @ResponseStatus(OK)
    fun update(@PathVariable id: Long, @Valid @RequestBody data: ConfigUpdateDto): ConfigDto {
        return ConfigDto().of(configService.update(id, data.toConfig()))
    }
}