package projet.application;

import IPRO.projet.typage.*;
import projet.typage.Name;
import projet.typage.Prix;
import projet.typage.Reference;

public interface ISellable {
    Reference getReferenceObject();
    Name getNameObject();
    Prix getPrixObject();
}