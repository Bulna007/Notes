package org.tools;

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class DebugTask extends DefaultTask {
    @Input
    String message = "default"

    @TaskAction
    def info() {
        println message
    }
}