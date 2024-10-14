package io.junseok.page

interface Page<T> {
    val content: List<T>
    val totalPage: Int
    val totalElement: Long
}

data class PageImpl<T>(
    override val content: List<T>,
    override val totalPage: Int,
    override val totalElement: Long
) : Page<T>