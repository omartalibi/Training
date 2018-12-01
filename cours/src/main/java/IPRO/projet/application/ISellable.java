package IPRO.projet.application;

import IPRO.projet.typage.Name;
import IPRO.projet.typage.Prix;
import IPRO.projet.typage.Reference;

public interface ISellable {
    Reference getReferenceObject();
    Name getNameObject();
    Prix getPrixObject();
}