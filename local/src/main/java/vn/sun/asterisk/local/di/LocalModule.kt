package vn.sun.asterisk.local.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import vn.sun.asterisk.common.KoinTags
import vn.sun.asterisk.data.data.source.CategoryDataSource
import vn.sun.asterisk.local.data.source.CategoryDataSourceImpl
import vn.sun.asterisk.local.db.AppDatabase

val localModule = module {
    single<CategoryDataSource> {
        CategoryDataSourceImpl(database = get())
    }

    single {
        AppDatabase.getDatabase(context = get(named(KoinTags.ANDROID_CONTEXT)))
    }
}
