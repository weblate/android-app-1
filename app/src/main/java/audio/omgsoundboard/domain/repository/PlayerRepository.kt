package audio.omgsoundboard.domain.repository

import android.net.Uri

enum class MediaManager {
    Ringtone,
    Alarm,
    Notification
}

interface PlayerRepository {

    fun playFile(index: Int, resourceId: Int, uri: Uri?)
    fun shareFile(fileName: String, resourceId: Int)
    fun setMedia(type: MediaManager, fileName: String, resourceId: Int, cUri: Uri?)
    fun addCustomSound(fileName: String, uri: Uri) : Uri?
}