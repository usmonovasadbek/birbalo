sealed class DownloadStatus {
    object Loading : DownloadStatus()
    data class Success(val fileName: String) : DownloadStatus()
    data class Failure(val errorMessage: String) : DownloadStatus()
}
fun downloadFile(fileName: String): DownloadStatus {
    println("Fayl yuklanmoqda: $fileName...")
    return when ((1..3).random()) {
        1 -> DownloadStatus.Success(fileName)
        2 -> DownloadStatus.Failure("Internet uzildi!")
        else -> DownloadStatus.Loading
    }
}
fun handleDownload(status: DownloadStatus) {
    when (status) {
        is DownloadStatus.Loading -> {
            println("Fayl hali yuklanmoqda...")
        }
        is DownloadStatus.Success -> {
            println("Fayl muvaffaqiyatli yuklandi: ${status.fileName}")
        }
        is DownloadStatus.Failure -> {
            println("Faylni yuklab olishda xato yuz berdi: ${status.errorMessage}")
        }
    }
}
fun main() {
    val fileName = "document.pdf"

    val status = downloadFile(fileName)

    handleDownload(status)
}
