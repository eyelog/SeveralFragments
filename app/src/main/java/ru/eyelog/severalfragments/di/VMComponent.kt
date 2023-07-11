package ru.eyelog.severalfragments.di

import dagger.Component
import ru.eyelog.severalfragments.FirstFragment
import ru.eyelog.severalfragments.FourthFragment
import ru.eyelog.severalfragments.MainActivity
import ru.eyelog.severalfragments.SecondFragment
import ru.eyelog.severalfragments.ThirdFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [VMModule::class])
interface VMComponent {


    @Component.Factory
    interface Factory{

        fun create(): VMComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: FirstFragment)
    fun inject(fragment: SecondFragment)
    fun inject(fragment: ThirdFragment)
    fun inject(fragment: FourthFragment)

}