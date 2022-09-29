package com.example.funnyfood.core

import com.example.funnyfood.R
import com.example.funnyfood.domain.ErrorType
import com.example.funnyfood.ui.ResourceProvider

abstract class Abstract {

    interface Object<T, M : Mapper> {

        fun map(mapper: M): T
    }

    interface Mapper {

        class Empty : Mapper

        interface Data<S, R> : Mapper {
            fun map(data: S): R
        }

        interface DomainToUi<S, T> : Data<S, T> {
            fun map(errorType: ErrorType): T

            abstract class Base<S, T>(private val resourceProvider: ResourceProvider) :
                    DomainToUi<S, T> {
                        protected fun errorMessage(errorType: ErrorType) = resourceProvider.getString(
                            when (errorType) {
                                ErrorType.NO_CONNECTION -> R.string.no_connection_message
                                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable_message
                                else -> R.string.something_went_wrong
                            }
                        )
                    }
        }
    }
}


