package di

import com.example.cardsort.CardSortApplication
import com.example.cardsort.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import android.app.Application
import dagger.BindsInstance


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        CardSortDbModule::class
    ]
)
interface AppComponent : AndroidInjector<CardSortApplication> {
    override fun inject(cardSortApplication: CardSortApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}
