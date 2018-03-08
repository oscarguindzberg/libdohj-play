package org.libdohj;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Utils;
import org.libdohj.params.DogecoinMainNetParams;
import org.libdohj.params.DogecoinRegTestParams;
import org.libdohj.params.DogecoinTestNet3Params;
import org.spongycastle.util.encoders.Hex;


/**
 * Created by oscar on 12/09/2017.
 */
public class Play5 {
    public static void main(String[] args) throws Exception {
        // Mainnet: DNrvDFYjWzvzq7c8hZChgjqobiCktobUi2
        // Testnet: nb8feE2DKxDotVnxr8675jFZZHyqCCb2mM
        NetworkParameters params = DogecoinMainNetParams.get();
        // Any dogecoin address
        System.out.println(new ECKey().toAddress(params));
        // Lock dogecoin address
        System.out.println(new Address(params, params.getAddressHeader(), Hex.decode("4d905b4b815d483cdfabcd292c6f86509d0fad82")));

        System.out.println(Hex.toHexString(Address.fromBase58(params, "DR4U7ZJXrAjX4MSGCbJ1wSc3JcJSELQnBc").getHash160()));

        System.out.println(new Address(params, params.getAddressHeader(), Hex.decode("0000000000000000000000000000000000000003")));

        NetworkParameters regTestParams = DogecoinRegTestParams.get();

        System.out.println(new Address(regTestParams, regTestParams.getAddressHeader(), Hex.decode("0000000000000000000000000000000000000004")));
    }


}