package org.hiedacamellia.nuclearelysian.register;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AutoRegistryObject<T> {
    private final Supplier<T> supplier;
    private RegistryObject<T> object;

    public AutoRegistryObject(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public void register(DeferredRegister<T> register, String name) {
        object = register.register(name, supplier);
    }

    public T get() {
        return object.get();
    }
}
