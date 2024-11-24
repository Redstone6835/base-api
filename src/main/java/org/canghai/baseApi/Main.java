package org.canghai.baseApi;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.plugin.java.JavaPlugin;
import org.canghai.baseApi.annotation.ApiBlock;
import org.canghai.baseApi.annotation.ApiEntity;
import org.canghai.baseApi.annotation.ApiEvent;
import org.canghai.baseApi.annotation.ApiItem;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("base-api 正在启动。。。");
        // 扫描指定包下的带有注解的类
        try (ScanResult scanResult = new ClassGraph()
                .enableClassInfo()
                .enableAnnotationInfo()
                .acceptPackages("org.canghai") // 指定扫描的包
                .scan()) {

            // 获取带特定注解的类
            scanResult.getClassesWithAnnotation(ApiBlock.class.getName())
                    .forEach(classInfo -> {
                        try {
                            // 加载类并处理
                            registerBlock(classInfo.loadClass());
                        } catch (Exception e) {
                            getLogger().severe("Error processing class: " + e.getMessage());
                        }
                    });

            scanResult.getClassesWithAnnotation(ApiEntity.class.getName())
                    .forEach(classInfo -> {
                        try {
                            // 加载类并处理
                            registerEntity(classInfo.loadClass());
                        } catch (Exception e) {
                            getLogger().severe("Error processing class: " + e.getMessage());
                        }
                    });

            scanResult.getClassesWithAnnotation(ApiEvent.class.getName())
                    .forEach(classInfo -> {
                        try {
                            // 加载类并处理
                            registerEvent(classInfo.loadClass());
                        } catch (Exception e) {
                            getLogger().severe("Error processing class: " + e.getMessage());
                        }
                    });

            scanResult.getClassesWithAnnotation(ApiItem.class.getName())
                    .forEach(classInfo -> {
                        try {
                            // 加载类并处理
                            registerItem(classInfo.loadClass());
                        } catch (Exception e) {
                            getLogger().severe("Error processing class: " + e.getMessage());
                        }
                    });


        }
    }

    private void registerBlock(Class<?> clazz) {
        getLogger().info("registerBlock: " + clazz.getName());
        // TODO
    }

    private void registerItem(Class<?> clazz) {
        getLogger().info("registerItem: " + clazz.getName());
        // TODO
    }

    private void registerEvent(Class<?> clazz) {
        getLogger().info("registerEvent: " + clazz.getName());
        // TODO
    }

    private void registerEntity(Class<?> clazz) {
        getLogger().info("registerEntity: " + clazz.getName());
        // TODO
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
