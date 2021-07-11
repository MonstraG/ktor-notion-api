package no.pls.adapters

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// https://stackoverflow.com/a/56078382/11593686
class LocalDateTypeAdapter : TypeAdapter<LocalDateTime>() {
    override fun write(out: JsonWriter, value: LocalDateTime) {
        out.value(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(value))
    }

    override fun read(input: JsonReader): LocalDateTime =
        LocalDateTime.parse(input.nextString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
}