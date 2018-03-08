package org.libdohj;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.PartialMerkleTree;
import org.libdohj.params.DogecoinTestNet3Params;


/**
 * Created by oscar on 12/09/2017.
 */
public class Play6 {
    public static void main(String[] args) throws Exception {
        int transactionCount = 6;
        int height = 2;
        System.out.println((transactionCount + (1 << height) - 1) >> height);

    }


}