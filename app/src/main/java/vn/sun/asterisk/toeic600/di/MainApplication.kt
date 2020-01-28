package vn.sun.asterisk.toeic600.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import vn.sun.asterisk.data.di.dataModule
import vn.sun.asterisk.domain.di.domainModule
import vn.sun.asterisk.local.di.localModule
import vn.sun.asterisk.presentation.di.presentationModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    localModule,
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
        }
    }
}
