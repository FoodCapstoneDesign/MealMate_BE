package io.junseok.mealmateapi.config

import org.springframework.context.ApplicationContext
import java.lang.reflect.Method

object AdminReaderProvider {
    private const val ADMIN_READER_CLASS = "io.junseok.domain.restaurantadmin.AdminReader"
    private const val ADMIN_JPA_REPOSITORY_CLASS = "io.junseok.mealmateadminapi.domain.AdminJpaRepository"
    private const val FIND_ADMIN_METHOD = "findAdmin"

    private lateinit var _applicationContext: ApplicationContext

    fun initializeApplicationContext(context: ApplicationContext) {
        _applicationContext = context
    }

    fun findAdmin(email: String): String? {
        return try {
            val adminReaderClass = Class.forName(ADMIN_READER_CLASS)
            val adminJpaRepositoryClass = Class.forName(ADMIN_JPA_REPOSITORY_CLASS)

            val adminJpaRepositoryBean = _applicationContext.getBean(adminJpaRepositoryClass)

            val adminReaderInstance = adminReaderClass
                .getConstructor(adminJpaRepositoryClass)
                .newInstance(adminJpaRepositoryBean)

            val findAdminMethod: Method = adminReaderClass.getMethod(FIND_ADMIN_METHOD, String::class.java)

            findAdminMethod.invoke(adminReaderInstance, email) as? String
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}