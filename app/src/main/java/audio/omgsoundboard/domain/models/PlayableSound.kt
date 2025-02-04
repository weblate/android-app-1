package audio.omgsoundboard.domain.models

import android.net.Uri
import audio.omgsoundboard.data.local.CustomSoundsEntity
import audio.omgsoundboard.data.local.FavoritesEntity

data class PlayableSound(
    var id: Int = 0,
    val title: String = "",
    val resId: Int = 0,
    val uri: Uri = Uri.EMPTY,
    var isFav: Boolean = false
)

fun FavoritesEntity.toDomain() = PlayableSound(
    id = id,
    title = title,
    resId = resId,
    uri = uri
)

fun CustomSoundsEntity.toDomain() = PlayableSound(
    id = id,
    title = title,
    uri = uri,
)