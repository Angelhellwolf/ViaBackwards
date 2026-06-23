plugins {
    base
    id("vb.build-logic")
}

allprojects {
    group = "com.viaversion"
    version = property("projectVersion") as String // from gradle.properties
    description = "允许较旧版本的 Minecraft 客户端连接到较新版本的服务器。"
}

val main = setOf(
    projects.viabackwards,
    projects.viabackwardsCommon,
    projects.viabackwardsBukkit,
    projects.viabackwardsVelocity
).map { it.path }

subprojects {
    when (path) {
        in main -> plugins.apply("vb.shadow-conventions")
        else -> plugins.apply("vb.base-conventions")
    }
}
