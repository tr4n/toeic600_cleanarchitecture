package vn.sun.asterisk.data.di

import org.koin.dsl.module
import vn.sun.asterisk.data.repository.CategoryRepositoryImpl
import vn.sun.asterisk.domain.repository.CategoryRepository

val dataModule = module {

    single<CategoryRepository> {
        CategoryRepositoryImpl(dataSource = get())
    }
}
