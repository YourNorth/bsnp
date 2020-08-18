package com.spring_boot.active_lead.itis.bsnp.service.impl;

import com.spring_boot.active_lead.itis.bsnp.dto.device.request.RequestDeviceModuleDto;
import com.spring_boot.active_lead.itis.bsnp.dto.device.request.RequestDeviceParameterDto;
import com.spring_boot.active_lead.itis.bsnp.dto.device.response.ResponseDeviceModelDto;
import com.spring_boot.active_lead.itis.bsnp.dto.device.response.ResponseDeviceParameterDto;
import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.Parameter;
import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import com.spring_boot.active_lead.itis.bsnp.repository.ModuleRepository;
import com.spring_boot.active_lead.itis.bsnp.repository.ParameterRepository;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    ParameterRepository parameterRepository;

    @Override
    public Optional<Module> findById(Long id) {
        Optional<Module> result = moduleRepository.findById(id);
        log.info("IN findById - id: {}, module:{}", id, result);
        return result;
    }

    @Override
    public List<Module> findAll() {
        List<Module> result = moduleRepository.findAll();
        log.info("IN findAll - count of modules:{}", result.size());
        return result;
    }

    @Override
    public Module save(Module module) {
        Module result = moduleRepository.save(module);
        log.info("IN save - module:{}", module);
        return result;
    }

    @Override
    public void delete(Module module) {

        log.info("IN delete - module: {}", module);
        moduleRepository.delete(module);
    }

    @Override
    public List<Module> findAllByTerrarium(Terrarium terrarium) {
        List<Module> result = moduleRepository.findAllByTerrarium(terrarium);
        log.info("IN findAllByTerrarium - terrarium: {}, count of models: {}", terrarium, result.size());
        return result;
    }

    @Override
    public Optional<Module> findByAddress(String address) {
        Optional<Module> result = moduleRepository.findByAddress(address);
        log.info("IN findByAddress - address: {}, module: {}", address, result);
        return result;
    }

    @Override
    public List<ResponseDeviceModelDto> getResponseForDevice(List<RequestDeviceModuleDto> modules) {
        List<ResponseDeviceModelDto> result = new LinkedList<>();
        for (RequestDeviceModuleDto requestModule : modules) {
            Optional<Module> module = findByAddress(requestModule.getName());
            if (module.isPresent()) {     //fixme
                boolean flag;
                ResponseDeviceModelDto responseDeviceModelDto =
                        ResponseDeviceModelDto.builder()
                                .module(module.get())
                                .address(module.get().getName())
                                .settings(new LinkedList<>())
                                .build();
                for (RequestDeviceParameterDto requestParam : requestModule.getParams()) {
                    for (Parameter parameter : module.get().getParameters()) {
                        if (parameter.getCode() == requestParam.getCode() && (parameter.getSetValue() - requestParam.getSet_value()) != 0) {
                            responseDeviceModelDto.getSettings().add(
                                    ResponseDeviceParameterDto.builder()
                                            .code(parameter.getCode())
                                            .set_value(requestParam.getSet_value())
                                            .build());
                            flag = true;
                            parameterRepository.save(Parameter
                                    .builder()
                                    .code(parameter.getCode())
                                    .id(parameter.getId())
                                    .module(parameter.getModule())
                                    .name(parameter.getName())
                                    .realValue(requestParam.getReal_value())
                                    .setValue(requestParam.getSet_value())
                                    .build());
                        }
                    }
                }
                result.add(responseDeviceModelDto);
            }
        }
        return result;
    }

}