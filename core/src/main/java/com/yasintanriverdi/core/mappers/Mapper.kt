package com.yasintanriverdi.core.mappers

interface Mapper<F, T> {
    suspend fun map(from: F): T
}