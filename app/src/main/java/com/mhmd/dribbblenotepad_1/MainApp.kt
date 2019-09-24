package com.mhmd.dribbblenotepad_1

import android.app.Application
import android.view.View
import com.jaredrummler.cyanea.Cyanea
import com.jaredrummler.cyanea.inflator.CyaneaViewProcessor
import com.jaredrummler.cyanea.inflator.decor.CyaneaDecorator
import com.jaredrummler.cyanea.inflator.decor.FontDecorator

class MainApp : Application(), CyaneaDecorator.Provider, CyaneaViewProcessor.Provider {
    
    override fun onCreate() {
        super.onCreate()
        Cyanea.init(this, resources)
        Cyanea.loggingEnabled = true
    }
    
    override fun getDecorators(): Array<CyaneaDecorator> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        FontDecorator()
    }
    
    override fun getViewProcessors(): Array<CyaneaViewProcessor<out View>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    
}