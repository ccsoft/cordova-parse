declare module CC {
    export interface ICordovaParse {
        getInstallationId: (successcb: (installationId: string) => void, failcb: (err: string) => void) => void;
        setKeyValue: (key, value, successcb?: () => void, failcb?: (err: string) => void) => void;
    }
}
