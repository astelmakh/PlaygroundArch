package com.playground.core_presentation_mvp.common.error

/**
 *  Helper for representing exceptions which comes to presentation layer into a user-friendly text
 */
object PresentationErrorFactory {

    fun create(
        exception: Throwable,
        content: Content? = null
    ): PresentationError {

        val titleResId = content?.titleResId
        val subtitleResId = content?.subtitleResId

        return PresentationError.Visual.Default()
    }

    data class Content(
        val titleResId: Int? = null,
        val subtitleResId: Int? = null
    )
}