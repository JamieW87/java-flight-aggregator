package org.deblock.exercise.service.impl;

import org.deblock.exercise.service.SupplierService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("toughjet")
public class ToughJetService implements SupplierService {
}
