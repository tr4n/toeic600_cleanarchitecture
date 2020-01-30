package vn.sun.asterisk.toeic600.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import vn.sun.asterisk.common.KoinTags

val appModule = module {
    single(named(KoinTags.ANDROID_CONTEXT)) {
        androidContext()
    }
}
