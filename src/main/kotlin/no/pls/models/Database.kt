package no.pls.models

import java.time.LocalDateTime

data class ListResponse<T>(
    val Object: String = "list",
    val results: List<T>
)

data class Database(
    val Object: String,
    val id: String,
    val createdTime: LocalDateTime,
    val lastEditedTime: LocalDateTime,
    var title: List<BaseRichText>,
    val properties: Any,
)


enum class TextColor {
    Default,
    Gray,
    Brown,
    Orange,
    Yellow,
    Green,
    Blue,
    Purple,
    Pink,
    Red,
    GrayBackground,
    BrownBackground,
    OrangeBackground,
    YellowBackground,
    GreenBackground,
    BlueBackground ,
    PurpleBackground,
    PinkBackground,
    RedBackground
}

data class Annotations(
    val bold: Boolean = false,
    val italic: Boolean = false,
    val strikethrough: Boolean = false,
    val underline: Boolean = false,
    val code: Boolean = false,
    val color: TextColor = TextColor.Default
)
