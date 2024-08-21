package th.observer.canvasbuilder

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform