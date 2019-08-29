package com.playground.corepresentation.error

sealed class PresentationError(val content: Content? = null) : Throwable() {

    sealed class Visual(content: Content? = null) : PresentationError(content) {
        class Default : Visual(
            Content(
                "Something went wrong."
            )
        )
    }

    sealed class Internal : PresentationError()

    data class Content(
        val title: String? = null,
        val subtitle: String? = null
    )
}