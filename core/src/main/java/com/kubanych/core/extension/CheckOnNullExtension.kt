package com.kubanych.core.extension

/**
 * Check on null - seven parameters
 */
inline fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, T6 : Any, T7 : Any, R : Any> safeLet(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    p4: T4?,
    p5: T5?,
    p6: T6?,
    p7: T7?,
    block: (T1, T2, T3, T4, T5, T6, T7) -> R?,
): R? {
    return if (p1 != null && p2 != null && p3 != null && p4 != null && p5 != null && p6 != null && p7 != null) block(
        p1,
        p2,
        p3,
        p4,
        p5,
        p6,
        p7) else null
}