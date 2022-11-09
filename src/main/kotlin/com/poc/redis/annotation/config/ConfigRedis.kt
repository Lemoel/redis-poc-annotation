package com.poc.redis.annotation.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.time.Duration

@Configuration
class ConfigRedis(
    @Value("\${spring.redis.caches-ttl.student}") private val ttlStudent: Long,
) {

    @Bean
    fun redisCacheManagerBuilderCustomizer(): RedisCacheManagerBuilderCustomizer {
        return RedisCacheManagerBuilderCustomizer { builder: RedisCacheManagerBuilder ->
            builder.withCacheConfiguration(
                "studentAnnotation",
                RedisCacheConfiguration
                    .defaultCacheConfig()
                    .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer())
                    ).entryTtl(Duration.ofMinutes(ttlStudent))
            )
        }
    }

}