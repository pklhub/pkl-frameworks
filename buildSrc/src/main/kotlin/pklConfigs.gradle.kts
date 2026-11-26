val pklConfigGenerator =
    project.extensions.create<GeneratePklConfigsExtension>("pklConfigs", project)


val generateTask = tasks.register("generatePkl", GeneratePklTask::class, pklConfigGenerator)
