package com.app.taiye.countries.di

import java.lang.annotation.Documented
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention
import javax.inject.Scope


@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation  class PerActivity {
}